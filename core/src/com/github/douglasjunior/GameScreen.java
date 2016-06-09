package com.github.douglasjunior;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;

import static com.github.douglasjunior.SampleGame.HEIGHT;
import static com.github.douglasjunior.SampleGame.WIDTH;

/**
 * Created by Douglas on 08/06/2016.
 */
public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private Stage stage;

    @Override
    public void show() {
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        stage = new Stage(new FillViewport(WIDTH, HEIGHT, camera));
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
