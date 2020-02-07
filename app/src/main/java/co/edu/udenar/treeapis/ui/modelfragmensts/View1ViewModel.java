package co.edu.udenar.treeapis.ui.modelfragmensts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class View1ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public View1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is view1 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}