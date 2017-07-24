package posidenpalace.com.walmartproblem.View;

public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
