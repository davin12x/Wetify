package co.bagga.wetify.Interface

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

/***
 * Callback to be called after http call for an endpoint
 */
interface HttpCallBack {
    /***
     * Method to be called after a successful HTTP request

     * @param response response for the HTTP request issued
     * *
     * @param responseCode response code for the HTTP request issued
     */
    fun onHttpRequestSuccess(response: String, responseCode: Int)

    /***
     * Method to be called after a failed HTTP request

     * @param response response for the HTTP request issued
     * *
     * @param responseCode response code for the HTTP request issued
     */
    fun onHttpRequestError(response: String, responseCode: Int)
}
