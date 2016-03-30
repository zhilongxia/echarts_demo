/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.zjjf.analysis.services.security;

import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.ehcache.EhCacheCacheManager;

public class ShiroCacheManager extends EhCacheManager{
	
	private static final Logger log = LoggerFactory.getLogger(ShiroCacheManager.class);
	
	private boolean cacheManagerImplicitlyCreated = false;
	
	private EhCacheCacheManager ehCacheCacheManager;

    @SuppressWarnings("unused")
	private net.sf.ehcache.CacheManager ensureCacheManager() {
        try {
            if (this.manager == null) {
                if (log.isDebugEnabled()) {
                    log.debug("cacheManager property not set.  Constructing CacheManager instance... ");
                }
                if(getEhCacheCacheManager() == null){
                	return null;
                }else{
                	this.manager = getEhCacheCacheManager().getCacheManager();
                }
                if (log.isTraceEnabled()) {
                    log.trace("instantiated Ehcache CacheManager instance.");
                }
                setCacheManagerImplicitlyCreated(true);
                if (log.isDebugEnabled()) {
                    log.debug("implicit cacheManager created successfully.");
                }
            }
            return this.manager;
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

	public boolean isCacheManagerImplicitlyCreated() {
		return cacheManagerImplicitlyCreated;
	}

	public void setCacheManagerImplicitlyCreated(boolean cacheManagerImplicitlyCreated) {
		this.cacheManagerImplicitlyCreated = cacheManagerImplicitlyCreated;
	}

	public EhCacheCacheManager getEhCacheCacheManager() {
		return ehCacheCacheManager;
	}

	public void setEhCacheCacheManager(EhCacheCacheManager ehCacheCacheManager) {
		this.ehCacheCacheManager = ehCacheCacheManager;
	}

}
