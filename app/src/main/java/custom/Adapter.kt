package custom

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bingo.databinding.BallItemBinding
import models.ViewModel


class Adapter(
    private val item: ArrayList<Int>,
    private val onBallPressed: (Int) -> Unit,
    private val viewModel: ViewModel,
    private val resources: Resources
) :
    RecyclerView.Adapter<Adapter.BallViewHolder>() {


    class BallViewHolder(private val binding: BallItemBinding, private var list: MutableList<Int>) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(
            ball: Int,
            onBallPressed: (Int) -> Unit,
            viewModel: ViewModel,
            resources: Resources
        ) {

            binding.ball.setOnClickListener {

                onBallPressed(ball)

                if (binding.ball.alpha == 1f &&  viewModel.ballSize()!! < 8) {
                    binding.ball.alpha = 0.5f
                    viewModel.addBall(resources.getResourceName(ball).drop(32))
                } else {
                    binding.ball.alpha = 1f
                    if (list.isEmpty()) {
                        viewModel.removeBall(resources.getResourceName(ball).drop(32))
                    }
                }
                if (viewModel.ballSize() == 8){
                    for (i in viewModel.balls.value!!){
                        println(viewModel.balls.value)
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
        holder.bind(item[position], onBallPressed, viewModel, resources)


    }

    override fun getItemCount(): Int {
        return item.size
    }

}