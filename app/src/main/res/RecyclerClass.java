import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;
import vfs.com.androidtableviews.RespositoryHolder;

/**
 * Created by Jaxonstevens on 8/9/17.
 */

public class RecyclerClass  extends RecyclerView.Adapter<RespositoryHolder> {



    private ArrayList<Repository> mRepositories;

    public RecyclerAdapter(ArrayList<Respository> respositories) {

        mRepositories = mRepositories;

    }

    @Override

    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflatedView = layoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item, parent, false);

        return new RepositoryHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(RespositoryHolder holder, int position) {

        Respository respository = mRepositories.get(position);
        holder.bindRepository(respository);

    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }
}


