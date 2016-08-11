package com.glennboudaer.gui;

import java.awt.SplashScreen;

public class ProgramLoader 
{
	public void load()
	{
		promptLoadingScreen();
	}
	
	private void promptLoadingScreen()
	{
		SplashScreen splashScreen = SplashScreen.getSplashScreen();
	}
}
