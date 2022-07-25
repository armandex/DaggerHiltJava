package aguinaga.armando.daggerhiltjava.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import aguinaga.armando.daggerhiltjava.data.model.Movie;
import aguinaga.armando.daggerhiltjava.databinding.FragmentFirstBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.modifyMyText(" Armando");
        mainViewModel.getObserverMovies(false, 1);
        mainViewModel.getMovies().observe(getViewLifecycleOwner(), movies -> {
            if (movies != null){
                Toast.makeText(requireContext(),"OK", Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(requireContext(),"NO OK", Toast.LENGTH_LONG).show();
        });
        binding.buttonFirst.setOnClickListener(view1 -> {
            String greetings = mainViewModel.getMyText();
            Toast.makeText(requireContext(),greetings, Toast.LENGTH_LONG).show();
            //NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}