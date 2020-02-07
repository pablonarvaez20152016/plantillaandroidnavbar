package co.edu.udenar.treeapis.ui.modelfragmensts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class View2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public View2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la  view2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}