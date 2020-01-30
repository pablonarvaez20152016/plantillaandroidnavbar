package co.edu.udenar.treeapis.ui.View0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class View0ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public View0ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}