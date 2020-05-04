package com.itesm.bookland;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

public class ContenedorFragmentos extends Fragment implements DataAdapter.OnEventListener{
    ArrayList<Book> books;
    private String bookEditorial;
    private String bookDescription;
    private String bookPrice;
    private RecyclerView recyclerViewFinal;
    private View vista;
    private LinearLayoutManager linearLayoutManager;
    private DataAdapter DataAdapter;
    static String categoria;
    private String bookImage;
    private String bookTitle;
    private String bookAuthor;

    public ContenedorFragmentos(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void onEventClick(int position) {
        String description = books.get(position).getDescription();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getActivity());
        dialogo.setMessage(description).setTitle("HEY!");
        dialogo.setPositiveButton("ACEPT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alerta = dialogo.create();
        alerta.show();
    }

    //METODOS OBTENIDOS DE CLASE VOLLEY DE PROFESOR CARRILLO
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contenedor_fragmentos, container, false);
        recyclerViewFinal = vista.findViewById(R.id.Contenedor_R);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewFinal.setLayoutManager(linearLayoutManager);
        Log.i("HEY","SE VA A CREAR LA LISTA");
        books = new ArrayList<>();
        final ContenedorFragmentos eventListener = this;
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://androidstorepddm.000webhostapp.com/services/getbooks.php?category="+categoria;
        Log.i("HEY",categoria);
        Log.i("url",url);
        JsonArrayRequest request = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        JSONArray jArray = response;
                        Log.i("HEY","ENTRANDO A JSON");
                        try {
                            for(int i = 0; i < jArray.length(); i++) {
                                JSONObject object = jArray.getJSONArray(i).getJSONObject(0);
                                bookImage = object.getString("url_picture");
                                bookTitle = object.getString("title");
                                bookAuthor = object.getString("author");
                                bookEditorial = object.getString("editorial");
                                bookDescription = object.getString("description");
                                bookPrice = object.getString("price");
                                books.add(new Book(bookImage, bookTitle, bookAuthor, bookEditorial, bookDescription, bookPrice));
                            }
                            Log.i("HEY","HEHEHEHEHHEHEHEHHEHEHEYYYY");
                            DataAdapter = new DataAdapter(books, eventListener);
                            recyclerViewFinal.setAdapter(DataAdapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error HAY UN ERROR" + error);
                    }
                });
        queue.add(request);
        return vista;
    }

    //METODOS OBTENIDOS DE CLASE VOLLEY DE PROFESOR CARRILLO
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
