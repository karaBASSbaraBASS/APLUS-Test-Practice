//package aplus.ui.widgets;
//
//import aplus.ui.base.BasePage;
//import okhttp3.*;
//
//
//import java.io.IOException;
//import java.util.concurrent.CompletableFuture;
//import java.util.logging.Handler;
//
////public class SpellChecker extends BasePage {
////
////    public void SpellCheckRequest(String text) {
////        OkHttpClient client = new OkHttpClient();
////
////        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
////        RequestBody body = RequestBody.create(mediaType, "text="+text+"language=en-US");
////        Request request = new Request.Builder()
////                .url("https://grammarbot.p.rapidapi.com/check")
////                .post(body)
////                .addHeader("content-type", "application/x-www-form-urlencoded")
////                .addHeader("x-rapidapi-host", "grammarbot.p.rapidapi.com")
////                .addHeader("x-rapidapi-key", "f6BF6Cgiz3mshky0UAk3hLtznYP4p1Fn3UUjsnanA1TjSUPOTu")
////                .build();
////
////        try {
////            Response response = client.newCall(request).execute();
////            System.out.println(response.body().string());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//public class CoreOkHttpPost  {
//    //слушатель событий, будет оповещен, когда запрос закончит выполняться.
//    private PostRequestListener postRequestListener;
//
//    public void setPostRequestListener(PostRequestListener postRequestListener) {
//        this.postRequestListener = postRequestListener;
//    }
//
//    public void makePostRequest(){
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("name_form", "key_client")
//                .add("key", keys[0])
//                .build();
//
//        DownloadManager.Request request = new Request.Builder()
//                .url("http://example.ru/index.php")
//                .post(formBody).build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("post request failed");
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                //берем ответ от сервера
//                final String responseString = response.body().string();
//                //Так как enqueue выполняется в отдельном потоке, соответственно
//                //onResponse тоже будет выполнен в том же (отдельном от главного) потоке.
//                //Активити и фрагменты не любят когда трогают View-элементы не в main потоке,
//                //поэтому решаем эту проблему Handler'ом. Иначе будет Exception.
//                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        notifyRequestExecuted(responseString);
//                    }
//                });
//            }
//        });
//    }
//
//    //оповещение можно вынести в отдельный метод
//    private void notifyRequestExecuted(String response){
//        if (postRequestListener != null)
//        {
//            postRequestListener.onResponse(response);
//        }
//    };
//
//    public interface PostRequestListener{
//        void onResponse(String response);
//    }