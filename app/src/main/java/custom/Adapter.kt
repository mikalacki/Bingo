package custom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bingo.databinding.BallItemBinding
import kotlin.properties.Delegates


class Adapter(private val item: ArrayList<Int>, private val onBallPressed: (Int) -> Unit) :
    RecyclerView.Adapter<Adapter.BallViewHolder>() {


    class BallViewHolder(private val binding: BallItemBinding, private var list: MutableList<Int>) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(ball: Int, onBallPressed: (Int) -> Unit) {



            binding.ball.setOnClickListener {

                onBallPressed(ball)

                if (binding.ball.alpha == 1f && list.size < 8) {
                    binding.ball.alpha = 0.5f
                    list.add(ball)
                } else {
                    binding.ball.alpha = 1f
                    if (list.isEmpty()) {
                        list.remove(ball)
                    }
                }
            }

            binding.ball.setBackgroundResource(ball)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.BallViewHolder {
        val binding = BallItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val list = mutableListOf<Int>()
        return BallViewHolder(binding, list)

    }

    override fun onBindViewHolder(holder: Adapter.BallViewHolder, position: Int) {
        holder.bind(item[position], onBallPressed)


    }

    override fun getItemCount(): Int {
        return item.size
    }

}