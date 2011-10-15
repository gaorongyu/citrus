/*
 * Copyright 2010 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.test2.module.action.form.field;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.service.form.Field;
import com.alibaba.citrus.turbine.dataresolver.FormField;

public class MyAction {
    @Autowired
    private HttpServletRequest request;

    public void doGetField(@FormField(name = "field1", group = "myGroup1") Field field) {
        setAttribute(field);
    }

    public void doGetFieldDontSkipAction(@FormField(name = "field1", group = "myGroup1", skipIfInvalid = false)//
    CustomErrors field) { // 注入custom errors应该也可以，其实就是field。
        setAttribute(field);
    }

    public void doGetFieldInstanceValue(@FormField(name = "field1", group = "myGroup1", groupInstanceKey = "aaa") String[] s) {
        setAttribute(s);
    }

    public void doGetFieldInstanceValueDontSkipAction(@FormField(name = "field2", group = "myGroup1", groupInstanceKey = "aaa", skipIfInvalid = false) Integer i) {
        setAttribute(i);
    }

    private void setAttribute(Object data) {
        request.setAttribute("actionLog", data);
    }
}
