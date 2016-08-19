package servletCart;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tikt on 16-8-17.
 */
@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {

    private String action;//表示购物车的动作,add,show,delete
    private ItemsDAO idao = new ItemsDAO();//商品业务逻辑类的对象

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if (null != request.getParameter("action")) {
            this.action = request.getParameter("action");
            if (action.equals("add")) {//添加商品
                if(addToCart(request, response)){

                    request.getRequestDispatcher("/success.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/failure.jsp").forward(request,response);
                }
            }
            if (action.equals("show")) {//显示购物车
                showCart(request, response);
            }
            if(action.equals("delete")){//删除购物车商品
                if(deleteFromCart(request,response)){
                    request.getRequestDispatcher("/cart.jsp").forward(request,response);
                }
            }
        }
    }

    private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Items item = idao.getItemsById(Integer.parseInt(id));
        if(cart.removeGoodsFromCart(item)){
            return true;
        }else{
            return false;
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }

    private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        String number = request.getParameter("num");
        Items item = idao.getItemsById(Integer.parseInt(id));

        //是否是第一次给购物车添加商品，需要给session中创建一个新的购物车对象
        if (request.getSession().getAttribute("cart") == null) {
            Cart cart = new Cart();
            request.getSession().setAttribute("cart", cart);

        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
            return true;
        } else {
            return false;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletLifeTest1 的销毁方法被执行");
    }
}
