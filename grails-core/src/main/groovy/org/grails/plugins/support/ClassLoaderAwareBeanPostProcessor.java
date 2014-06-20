/*
 * Copyright 2003-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.support;

import org.codehaus.groovy.grails.plugins.support.BeanPostProcessorAdapter;
import grails.core.support.ClassLoaderAware;
import org.springframework.beans.BeansException;

public class ClassLoaderAwareBeanPostProcessor extends BeanPostProcessorAdapter {

    private ClassLoader classLoader;

    public ClassLoaderAwareBeanPostProcessor(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ClassLoaderAware) {
            ((ClassLoaderAware)bean).setClassLoader(classLoader);
        }
        return bean;
    }
}