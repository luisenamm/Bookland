package com.itesm.bookland;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
//CLASE OBTENIDA DE EJEMPLO DE PROFESOR CARRILLO

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.UserViewHolder> {

    //this context we will use to inflate the layout
    private Context context;

    //we are storing all the users in a list
    private ArrayList<Book> userBooks;
    private OnEventListener listener;


    public DataAdapter(ArrayList<Book> userList,OnEventListener onEventListener) {
        this.userBooks = userList;
        this.listener=onEventListener;
    }
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user_layout,
                parent, false),
                listener);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        //getting the user of the specified position
        Book book = userBooks.get(position);
        Picasso.get().load(book.getImageUrl()).into(holder.imageView);
        holder.textViewTitle.setText(book.getTitle());
        holder.textViewAuthor.setText(book.getAuthor());
        holder.textViewEditorial.setText(book.getEditorial());
        holder.textViewDescription.setText(book.getDescription());
        holder.textViewPrice.setText(book.getPrice());

    }
    @Override
    public int getItemCount()
    {
        return userBooks.size();
    }

    //METODO OBTENIDO DE EJEMPLO FIRST SQL ITEM DE PROFESOR CARRILLO
    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnEventListener onEventListener;
        TextView textViewTitle, textViewAuthor, textViewEditorial,textViewDescription,textViewPrice;
        ImageView imageView;

        public UserViewHolder(View itemView, OnEventListener listener) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewEditorial = itemView.findViewById(R.id.textViewEditorial);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
            this.onEventListener = listener;
        }
        @Override
        public void onClick(View v) {
            onEventListener.onEventClick(getAdapterPosition());
        }
    }
    public interface OnEventListener {
        void onEventClick(int position);
    }
}