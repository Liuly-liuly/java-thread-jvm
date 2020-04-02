package cn.designer.chapter7;

import org.omg.PortableInterceptor.ACTIVE;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/21
 * @since JDK 1.8
 */
public class ActionContext {

    private ThreadLocal<Context> local = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder{
        private final static ActionContext instance = new ActionContext();
    }

    public static ActionContext getInstance(){
        return ContextHolder.instance;
    }

    public Context getContext(){
        return local.get();
    }

    private ActionContext(){}
}
