package com.github.douglasjunior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.github.douglasjunior.libgdxTextareaHighlighting.code_editor.CodeEditor;

import static com.github.douglasjunior.SampleGame.HEIGHT;
import static com.github.douglasjunior.SampleGame.WIDTH;

/**
 * Created by Douglas on 08/06/2016.
 */
public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;

    @Override
    public void show() {
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        stage = new Stage(new FillViewport(WIDTH, HEIGHT, camera));
        Gdx.input.setInputProcessor(stage);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/mono.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = 13;
        params.color = Color.WHITE;
        font = generator.generateFont(params);
        generator.dispose();

        skin = new Skin();
        skin.add("default-font", font, BitmapFont.class);

        FileHandle fileHandle = Gdx.files.internal("uiskin/uiskin.json");
        FileHandle atlasFile = fileHandle.sibling("uiskin.atlas");
        if (atlasFile.exists()) {
            skin.addRegions(new TextureAtlas(atlasFile));
        }
        skin.load(fileHandle);

        CodeEditor editor = new CodeEditor(skin);
        editor.setPosition(20, 50);
        editor.setSize(600, 300);
        editor.setText("/* Finds the lowest common multiple (LCM) of two numbers */\n" +
                "function LCMCalculator(x, y) { // constructor function\n" +
                "    var checkInt = function (x) { // inner function\n" +
                "        if (x % 1 !== 0) {\n" +
                "            throw new TypeError(x + \" is not an integer\"); // throw an exception\n" +
                "        }\n" +
                "        return x;\n" +
                "    };\n" +
                "    this.a = checkInt(x)\n" +
                "    //   semicolons   ^^^^  are optional, a newline is enough\n" +
                "    this.b = checkInt(y);\n" +
                "}");
        stage.addActor(editor);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
