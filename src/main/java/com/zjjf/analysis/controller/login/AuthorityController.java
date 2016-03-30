package com.zjjf.analysis.controller.login;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjjf.analysis.beans.analysis.users.UserInfos;
import com.zjjf.analysis.beans.login.ScManager;
import com.zjjf.analysis.beans.vo.LoginVo;
import com.zjjf.analysis.beans.vo.ModelMsg;
import com.zjjf.analysis.constants.LoginConstant;
import com.zjjf.analysis.constants.SessionConfig;
import com.zjjf.analysis.controller.BaseController;
import com.zjjf.analysis.services.security.AuthorityServiceImpl;
import com.zjjf.analysis.utils.ResponseUtils;

@Controller
@RequestMapping(value = "/analysis/authority")
public class AuthorityController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(AuthorityController.class);

	@Autowired
	AuthorityServiceImpl authorityService;
    
	@RequestMapping(value = "/scmsLoginPage.do")
	@ResponseBody
	public Object scMgLoginIn(LoginVo loginRo,  HttpSession session,HttpServletRequest request,Model model) {
		//参数校验
		if (loginRo == null || StringUtils.isEmpty(loginRo.getUserName()) || StringUtils.isEmpty(loginRo.getPassword()) ) {
			return ResponseUtils.sendMsg(false, "请输入用户名密码后登陆！");
		}
		//防止重复登陆
		ScManager scmser = getCurrentUser(ScManager.class,request);
		if (scmser != null) {
			return ResponseUtils.sendMsg(true,"用户已登陆", LoginConstant.already_login_url);
		}
		//校验验证码
		if (StringUtils.isEmpty(loginRo.getCheckCode())) {
			session.removeAttribute(SessionConfig.user_session_code);
			return ResponseUtils.sendMsg(false, "验证码不能为空");
		}
		String serverCode = (String) session.getAttribute(SessionConfig.user_session_code);
		if (serverCode == null || !serverCode.toLowerCase().equals(loginRo.getCheckCode().trim().toLowerCase())) {
			session.removeAttribute(SessionConfig.user_session_code);
			return ResponseUtils.sendMsg(false, "验证码错误");
		}
		//处理登陆
		try {
			UsernamePasswordToken logintoken = new UsernamePasswordToken(loginRo.getUserName(), loginRo.getPassword(), true);
			try {
				SecurityUtils.getSubject().login(logintoken);
			}catch(UnknownAccountException une){
				return ResponseUtils.sendMsg(false, "对不起您还没有注册");
			}catch (Exception e) {
				logger.error("用户登陆异常：{}",loginRo.getUserName(),e);
				return ResponseUtils.sendMsg(false, "用户名或密码不正确");
			}
			ModelMsg msg = authorityService.dealSuccessLogin(loginRo,request,model);
			if(msg != null && msg.isSuccess()){
				return ResponseUtils.sendMsg(true, "登陆成功", LoginConstant.already_login_url);				
			}else{				
				return ResponseUtils.sendMsg(false, msg.getMessage());				
			}
		} catch (Exception e) {
			logger.error("用户登陆后处理异常：",e);
			return ResponseUtils.sendMsg(false, "登陆异常");
		}
	}
	
	@RequestMapping(value = "/scMgLoginIn.do")
	public String gotoLoginPage(HttpServletRequest request) throws IOException {

		return LoginConstant.main_url;
	}

	@RequestMapping(value = "/scmsMainPage.do")
	public String index(HttpServletRequest request, Model model) {

//		Subject subject = SecurityUtils.getSubject();
//		if(subject.isAuthenticated()){
//			LoginVo logInVo = new LoginVo();
//			UserInfos user =(UserInfos)subject.getSession().getAttribute(SessionConfig.user_session_userInfo);
//			if(user == null){
//				return LoginConstant.login_url;
//			}else{
//				logInVo.setUserId(user.getId());
//				logInVo.setUserName(user.getUserName());
//			}
//			model.addAttribute("logInVo", logInVo);
//			return LoginConstant.main_url;
//		}else{
			return LoginConstant.login_url;
//		}
	}

	@RequestMapping(value = "/toMainPage.do", method = RequestMethod.GET)
	public String toMain() {
		try {
			return "index/index";
		} catch (Exception e) {
			// TODO 错误页
			return "";
		}
	}

	/**
	 * 获取二维码
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkcode.do", method = RequestMethod.GET)
	public void checkcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		int width = 120;
		int height = 35;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 创建BufferedImage类的对象
		Graphics g = image.getGraphics(); // 创建Graphics类的对象
		Graphics2D g2d = (Graphics2D) g; // 通过Graphics类的对象创建一个Graphics2D类的对象
		Random random = new Random(); // 实例化一个Random对象
		Font mFont = new Font("华文宋体", Font.BOLD, 30); // 通过Font构造字体
		g.setColor(getRandColor(200, 250)); // 改变图形的当前颜色为随机生成的颜色
		g.fillRect(0, 0, width, height); // 绘制一个填色矩形

		// 画一条折线
		BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); // 创建一个供画笔选择线条粗细的对象
		g2d.setStroke(bs); // 改变线条的粗细
		g.setColor(Color.DARK_GRAY); // 设置当前颜色为预定义颜色中的深灰色
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		for (int j = 0; j < 3; j++) {
			xPoints[j] = random.nextInt(width - 1);
			yPoints[j] = random.nextInt(height - 1);
		}
		g.drawPolyline(xPoints, yPoints, 3);
		// 生成并输出随机的验证文字
		g.setFont(mFont);
		String sRand = "";
		int itmp = 0;
		for (int i = 0; i < 4; i++) {
			if (random.nextInt(2) == 1) {
				itmp = random.nextInt(26) + 65; // 生成A~Z的字母
			} else {
				itmp = random.nextInt(10) + 48; // 生成0~9的数字
			}
			char ctmp = (char) itmp;
			sRand += String.valueOf(ctmp);
			Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110));
			g.setColor(color);
			g.drawString(String.valueOf(ctmp), 30 * i + 10, 25);

		}
		g.dispose();
		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		session.setAttribute(SessionConfig.user_session_code, sRand);
		System.out.println("生成登陆验证码{}" + sRand);
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	private Color getRandColor(int a, int b) {
		Random random = new Random();
		Color color = new Color(50 + random.nextInt(110), a, b);
		return color;
	}

	@RequestMapping(value = "/supplierLoginIn.do")
	@ResponseBody
	public Object supplierLoginIn(LoginVo loginRo, HttpSession session, HttpServletRequest request, Model model) {
		// 参数校验
		if (loginRo == null || StringUtils.isEmpty(loginRo.getUserName()) || StringUtils.isEmpty(loginRo.getPassword())) {
			return ResponseUtils.sendMsg(false, "请输入用户名密码后登陆！");
		}
		// 防止重复登陆
		UserInfos sp = getCurrentUser(UserInfos.class, request);
		if (sp != null) {
			return ResponseUtils.sendMsg(true, "用户已登陆", LoginConstant.already_login_url);
		}
		// 校验验证码
		if (StringUtils.isEmpty(loginRo.getCheckCode())) {
			session.removeAttribute(SessionConfig.user_session_code);
			return ResponseUtils.sendMsg(false, "验证码不能为空");
		}
		String serverCode = (String) session.getAttribute(SessionConfig.user_session_code);
		if (serverCode == null || !serverCode.toLowerCase().equals(loginRo.getCheckCode().trim().toLowerCase())) {
			session.removeAttribute(SessionConfig.user_session_code);
			return ResponseUtils.sendMsg(false, "验证码错误");
		}
		// 处理登陆
		try {
			UsernamePasswordToken logintoken = new UsernamePasswordToken(loginRo.getUserName(), loginRo.getPassword(), true);
			try {
				SecurityUtils.getSubject().login(logintoken);
			} catch (UnknownAccountException une) {
				return ResponseUtils.sendMsg(false, "对不起您还没有注册");
			} catch (Exception e) {
				logger.error("用户登陆异常：{}", loginRo.getUserName(), e);
				return ResponseUtils.sendMsg(false, "用户名或密码不正确");
			}
			// ModelMsg msg =
			// authorityService.dealSupplierSuccessLogin(loginRo,request,model);
			ModelMsg msg = authorityService.dealSuccessLogin(loginRo, request, model);
			if (msg != null && msg.isSuccess()) {
				return ResponseUtils.sendMsg(true, "登陆成功", LoginConstant.already_login_url);
			} else {
				return ResponseUtils.sendMsg(false, msg.getMessage());
			}
		} catch (Exception e) {
			logger.error("用户登陆后处理异常：", e);
			return ResponseUtils.sendMsg(false, "登陆异常");
		}
	}

}
