package co.edu.udenar.treeapis.ui.view3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class View3ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public View3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is view3 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}