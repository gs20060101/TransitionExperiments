package com.example.gens.transitionplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Scene mScene1;
    private Scene mScene2;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ViewGroup sceneRoot = (ViewGroup) rootView.findViewById(R.id.scene_root);

        mScene1 = new Scene(sceneRoot, (ViewGroup) sceneRoot.findViewById(R.id.scene));

        mScene2 = Scene.getSceneForLayout(
            sceneRoot,
            R.layout.fragment_transition_scene_2,
            getActivity()
        );

        Button downButton = (Button) rootView.findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mScene2);
            }
        });

        Button upButton = (Button) rootView.findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mScene1);
            }
        });

        return rootView;
    }
}
