package zevatron.com.br.milho;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zevatron on 12/06/17.
 */

public class GastoAdapter extends BaseAdapter {

    private Cadastro cadastro;
    private Context context;

    public GastoAdapter(Context context, Cadastro cadastro) {
        this.cadastro = cadastro;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.cadastro.getQuantidadeGastos();
    }

    @Override
    public Object getItem(int position) {
        return this.cadastro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;

        if(convertView==null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = li.inflate(R.layout.list_item_gasto,null);
        }else
            layout = convertView;

        TextView tvDescricao = (TextView) layout.findViewById(R.id.tvListaItemDescricao);
        TextView tvQtd = (TextView) layout.findViewById(R.id.tvListaItemQuantidade);
        TextView tvValor = (TextView) layout.findViewById(R.id.tvListaItemValorUn);
        TextView tvTotal = (TextView) layout.findViewById(R.id.tvListaItemValorTotal);
        ImageView ivFoto = (ImageView) layout.findViewById(R.id.ivFotoLista);

        Gasto g = this.cadastro.get(position);

        tvDescricao.setText(g.getDescricao());
        tvQtd.setText(String.format("Qtd: %d",g.getQuantidade()));
        tvValor.setText(String.format("Valor Un: R$ %.2f",g.getValor()));
        tvTotal.setText(String.format("Total: R$ %.2f",g.getTotal()));
        if(g.getFoto()!=null)
            ivFoto.setImageDrawable(g.getFoto());

        layout.setMinimumHeight(100);

        if(position % 2 == 0 ){
            layout.setBackgroundColor(Color.rgb(220,220,220));
        }


        return layout;
    }


//    private List<Gasto> gastos;
//    private Activity context;
//
//    public GastoAdapter(Activity context,List<Gasto> gastos){
//        super(context,R.layout.list_item_gasto,gastos);
//        this.context = context;
//        this.gastos = gastos;
//    }
//
//    public synchronized void refreshList(List<Gasto> gastosAtualizado) {
//        this.gastos.clear();
//        this.gastos.addAll(gastosAtualizado);
//        notifyDataSetChanged();
//    }
//
//    private static class ViewHolder{
//        public TextView tvHolderDescricao;
//        public TextView tvHolderQtd;
//        public TextView tvHolderValor;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View linhaParaPopular = convertView;
//        ViewHolder holder;
//        if(linhaParaPopular == null){
//            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            linhaParaPopular = inflater.inflate(R.layout.list_item_gasto,null);
//
//            holder = new ViewHolder();
//            holder.tvHolderDescricao=(TextView) linhaParaPopular.findViewById(R.id.tvListaItemDescricao);
//            holder.tvHolderQtd = (TextView) linhaParaPopular.findViewById(R.id.tvListaItemQuantidade);
//            holder.tvHolderValor = (TextView) linhaParaPopular.findViewById(R.id.tvListaItemValorUn);
//
//            linhaParaPopular.setTag(holder);
//        }else{
//            holder = (ViewHolder) linhaParaPopular.getTag();
//        }
//        holder.tvHolderDescricao.setText(this.gastos.get(position).getDescricao());
//        holder.tvHolderValor.setText(String.format("RS%s",this.gastos.get(position).getValor()));
//
//        return linhaParaPopular;

}



