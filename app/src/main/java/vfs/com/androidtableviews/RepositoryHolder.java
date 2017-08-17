package vfs.com.androidtableviews;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jaxonstevens on 8/9/17.
 */

public class RepositoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView mImageView;
    private TextView mHomeTextView;
    private TextView mUpdatedTextView;

    public RepositoryHolder(View view) {
        super(view);

        mImageView = (ImageView) view.findViewById(R.id.Image_View);
        mHomeTextView = (TextView) view.findViewById(R.id.Last_Updated_View);
        mUpdatedTextView = (TextView) view.findViewById(R.id.TextView);

    }


    public void bindRepository(Repository repository) {

        mHomeTextView.setText(repository.getName());

    }

    @Override
    public void onClick(View v) {
        Log.i("RepositoryHolder", "Clicked");
    }
}