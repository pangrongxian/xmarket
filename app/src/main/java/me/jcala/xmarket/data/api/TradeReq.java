package me.jcala.xmarket.data.api;

import java.util.List;

import lombok.Getter;
import me.jcala.xmarket.conf.ApiConf;
import me.jcala.xmarket.data.dto.Result;
import me.jcala.xmarket.data.pojo.Trade;
import me.jcala.xmarket.data.pojo.TradeTag;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface TradeReq {

     int GET_TAG=1;
     int GET_NAME=2;

    /**
     * 获取分类列表请求(List<TradeTag>)
     *
     * kind设置为1
     */
    @GET(ApiConf.get_tags)
    Observable<Result<List<TradeTag>>> tradeTags(@Query("kind") int kind);


    /**
     * 获取分类名称列表请求(List<String>)
     *
     * kind设置为2
     */
    @GET(ApiConf.get_tags)
    Observable<Result<List<String>>> tagNames(@Query("kind") int kind);

    /**
     * 根据商品Id获取商品详细信息
     */
    @GET(ApiConf.get_trade)
    Observable<Result<Trade>> tradeDetail(@Path("tradeId") String tradeId);

    /**
     * 发布商品
     */
    @Multipart
    @POST(ApiConf.create_trade)
    Observable<Result<String>> addTrade(
            // TODO: 16-12-10 没有根据服务器修改
            @Path("userId")String userId,
            @Part("trade") RequestBody trade,
            @Part List<MultipartBody.Part> parts);
}