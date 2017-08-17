package vfs.com.androidtableviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jaxonstevens on 8/9/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RepositoryHolder> {

    private ArrayList<Repository> mRepositories;

    public RecyclerAdapter(ArrayList<Repository> repositories) {
        mRepositories = repositories;
    }


    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_repository, parent, false);
        return new RepositoryHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        Repository repository = mRepositories.get(position);
        holder.bindRepository(repository);

    }

    @Override
    public int getItemCount() {

        return mRepositories.size();
    }
}
