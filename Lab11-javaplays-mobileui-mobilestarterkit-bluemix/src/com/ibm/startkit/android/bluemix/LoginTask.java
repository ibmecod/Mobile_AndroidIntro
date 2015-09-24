/*
 * Copyright 2015 IBM Corp. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.startkit.android.bluemix;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

/*

Class to call the server side Login REST API
and validate the user
 */

import android.util.Log;
import android.widget.Toast;

import com.ibm.android.asynctask.AsyncServiceTask;


public class LoginTask  extends AsyncServiceTask {

	public static String _LOGIN_TASK_ID = "Log in";
	
	private String _loginURL ;
	
	
	public LoginTask( String loginURL ){

		//call the base class' constructor to assign a String
		//ID for this task
		super( _LOGIN_TASK_ID );
		
		_loginURL = loginURL ;
	}
	
	//override the base class' function to define the task
	@Override
	protected String performTask(String... params) throws IOException,
			JSONException, URISyntaxException {

		//TODO: call the server's login REST API
		//retrieve the user ID and password from the params...
		//retrieve the user ID and password from the params...
		String userID    = params[0];
		String password  = params[1];

		Log.i("LoginTask", userID);
		Log.i("LoginTask", password);

		//prepare a JSON object
		JSONObject credential = new JSONObject();
		credential.put( "user_id", userID );
		credential.put("password", password);

		//perform the post operation using the base class' utlity function
		return performPost( _loginURL , credential.toString(), null, null );
	}

}
