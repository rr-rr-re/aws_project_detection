package practice1.nettest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ProofWeb implements ContainerResponseFilter, ContainerRequestFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext cres)
			throws IOException {


		//ここは本来クライアント配置アドレスが入るが、ひとまず受け取ったoriginをそのまま返却することでクロスドメインを許可する
		//必要ならoriginアドレスのチェックをして認証せよ
/*
		String ori = "*";
		List<String> orilist = requestContext.getHeaders().get("origin");
		if(orilist == null) {
			return;
		}
		if(orilist.size() > 0)
		{
			ori = orilist.get(0);
		}*/

		//
		cres.getHeaders().add("Access-Control-Allow-Origin", "http://54.150.201.245");
		cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, X-PINGOTHER");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		//responseContext.getHeaders().add("TEST-RESP_AAAAA", ori);
		if (requestContext.getMethod().equalsIgnoreCase("OPTIONS")) {
			cres.getHeaders().add("Access-Control-Allow-Headers", requestContext.getHeaderString("Access-Control-Request-Headers"));
        }
	}

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		if (isPreflightRequest(requestContext)) 
		{ requestContext
					.abortWith(
            		 Response
            		  .ok()
            		.build());
	}
} 
	private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
	}
}
