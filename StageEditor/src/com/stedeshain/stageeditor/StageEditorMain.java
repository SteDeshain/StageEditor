package com.stedeshain.stageeditor;

import org.luaj.vm2.lib.ResourceFinder;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.stedeshain.loop.Engine.Component.Button;
import com.stedeshain.loop.Engine.Component.Button.OnClickListener;
import com.stedeshain.loop.Engine.Scene.Scene;
import com.stedeshain.loop.Engine.Utils.FontLibrary;
import com.stedeshain.loop.Engine.Utils.LazyBitmapFont;
import com.stedeshain.loop.Engine.Utils.Utils;

public class StageEditorMain extends com.stedeshain.loop.Engine.Game
{
	Button createStage;
	
	public StageEditorMain(String scriptPath, ResourceFinder androidLuaScriptFinder, int androidTouchSlop)
	{
		super(scriptPath, androidLuaScriptFinder, androidTouchSlop);
	}

	@Override
	public void create()
	{
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		this.setUIViewport(new Vector2(800, 480));
		Utils.setChckBtnPicTxtPadding(2);
		// this.setDebugMode(true);
		this.setHasDragBug(true);

		BitmapFont font = FontLibrary.get("lanting.ttf", 50);

		Button createUI = new Button("制作UI界面", font);
		createUI.setViewportAnchor(0.5f, 0.7f);
		createUI.setSourceAnchor(0.5f, 0.5f);
		createUI.setPressedColor(Color.CYAN);
		
		createStage = new Button("制作关卡界面", font);
		createStage.setViewportAnchor(0.5f, 0.4f);
		createStage.setSourceAnchor(0.5f, 0.5f);
		createStage.setPressedColor(Color.CYAN);
		createStage.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick()
			{
				Gdx.input.getTextInput(new TextInputListener()
				{
					@Override
					public void input(String text)
					{
						createStage.getLabel().setText(text);
					}
					
					@Override
					public void canceled()
					{
					}
				},
				"Title", "", "hint");
			}
		});

		Scene title = new Scene(this, null);
		title.addComponent(createUI);
		title.addComponent(createStage);

		this.setFirstScene(title);

		super.create();

	}

	@Override
	public void dispose()
	{
		super.dispose();
	}
}
