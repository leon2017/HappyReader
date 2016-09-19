/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leonwang.app.chinashop.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.leonwang.app.chinashop.R;


/**
 * Android通用工具方法
 * @author  LeonWang
 * @version 1.0
 * @created 2016-9-19
 */
public class CommonUtils
{
	
	/**
	 * 获取系统版本名称
	 */
    public static String getVersionName(Context context)//获取版本号  
    {  
        try {  
            PackageInfo pi=context.getPackageManager().getPackageInfo(context.getPackageName(), 0);  
            return pi.versionName;  
        } catch (NameNotFoundException e) {  
            e.printStackTrace();  
            return context.getString(R.string.versionname_unknown);
        }  
    }  
    /**
     * 获取系统版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context)//获取版本号(内部识别号)  
    {  
        try {  
            PackageInfo pi=context.getPackageManager().getPackageInfo(context.getPackageName(), 0);  
            return pi.versionCode;  
        } catch (NameNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return 0;  
        }  
    }  
    
    /**
     * 获取线程堆栈信息
     * @return
     */
    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }
    public static StackTraceElement getCurrentStackTraceElement() {
        return Thread.currentThread().getStackTrace()[3];
    }
	
}
