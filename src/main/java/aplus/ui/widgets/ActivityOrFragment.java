package aplus.ui.widgets;


public class ActivityOrFragment implements CoreOkHttpPost.PostRequestListener {

    public void makeRequest() {
        CoreOkHttpPost coreOkHttpPost = new CoreOkHttpPost();
        coreOkHttpPost.makePostRequest();
        coreOkHttpPost.makePostRequest();
    };

    @Override
    public void onResponse(String response) {
        //твой ответ здесь
    };
};
