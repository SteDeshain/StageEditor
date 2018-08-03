package com.stedeshain.stageeditor;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main
{
	public static void main(String[] args)
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Stage Editor";
		cfg.width = 800;
		cfg.height = 480;
		cfg.allowSoftwareMode = true;
		cfg.resizable = false;
		cfg.fullscreen = false;
		cfg.x = -1;
		cfg.y = -1;
		cfg.vSyncEnabled = true;

		new LwjglApplication(new StageEditorMain("../StageEditor-android/assets/scripts/?.lua", null, 0), cfg);
	}
}
