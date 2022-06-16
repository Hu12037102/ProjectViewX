package io.google.projectview.weight

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import io.google.projectview.Contract
import io.google.projectview.R
import io.google.projectview.Utils
import io.google.projectview.databinding.WeightItemViewBinding

/**
 * 作者: 胡庆岭
 * 创建时间:
 * 更新时间:
 * 描述:
 */
class ProjectView : ConstraintLayout {
    private val mViewBinding: WeightItemViewBinding by lazy {
        WeightItemViewBinding.inflate(
            LayoutInflater.from(context),
            this,
            false
        )
    }
    private var mOnItemInfoClickListener: OnItemInfoClickListener? = null
    fun setOnItemInfoClickListener(onItemInfoClickListener: OnItemInfoClickListener?) {
        this.mOnItemInfoClickListener = onItemInfoClickListener
    }

    fun getLeftView(): TextView {
        return mViewBinding.atvLeft
    }

    fun getCenterView(): TextView {
        return mViewBinding.atvCenter
    }

    fun getRightView(): TextView {
        return mViewBinding.atvRight
    }

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {


        this.addView(mViewBinding.root)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProjectView)

        /******************************************left**********************************************************/
        val leftStartDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_left_start_src)
        val leftTopDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_left_top_src)
        val leftEndDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_left_end_src)
        val leftBottomDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_left_bottom_src)
        mViewBinding.atvLeft.setCompoundDrawablesWithIntrinsicBounds(
            leftStartDrawable,
            leftTopDrawable,
            leftEndDrawable,
            leftBottomDrawable
        )
        val leftParams = mViewBinding.atvLeft.layoutParams
        if (leftParams is MarginLayoutParams) {
            leftParams.leftMargin =
                typedArray.getDimensionPixelSize(
                    R.styleable.ProjectView_pv_left_margin_start,
                    Utils.dp2px(context, Contract.DEFAULT_MARGIN.toFloat())
                )
            leftParams.topMargin =
                typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_left_margin_top, 0)
            leftParams.rightMargin =
                typedArray.getDimensionPixelSize(
                    R.styleable.ProjectView_pv_left_margin_end,
                    Utils.dp2px(context, Contract.DEFAULT_MARGIN.toFloat())
                )
            leftParams.bottomMargin =
                typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_left_margin_bottom, 0)
            mViewBinding.atvLeft.layoutParams = leftParams

        }
        val leftPaddingStart =
            typedArray.getDimensionPixelSize(
                R.styleable.ProjectView_pv_left_padding_start,
                Utils.dp2px(context, Contract.DEFAULT_PADDING.toFloat())
            )
        val leftPaddingTop =
            typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_left_padding_top, 0)
        val leftPaddingEnd =
            typedArray.getDimensionPixelSize(
                R.styleable.ProjectView_pv_left_padding_end,
                Utils.dp2px(context, Contract.DEFAULT_PADDING.toFloat())
            )
        val leftPaddingBottom =
            typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_left_padding_bottom, 0)
        mViewBinding.atvLeft.setPadding(
            leftPaddingStart,
            leftPaddingTop,
            leftPaddingEnd,
            leftPaddingBottom
        )

        val leftDrawablePadding =
            typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_left_drawable_padding, 0)
        mViewBinding.atvLeft.compoundDrawablePadding = leftDrawablePadding
        val leftText = typedArray.getString(R.styleable.ProjectView_pv_left_text)
        mViewBinding.atvLeft.text = leftText
        val leftTextSize = typedArray.getDimensionPixelSize(
            R.styleable.ProjectView_pv_left_text_size,
            getDefaultTextSize()
        )
        mViewBinding.atvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize.toFloat())
        val leftTextColor =
            typedArray.getColor(R.styleable.ProjectView_pv_left_text_color, Color.BLACK)
        mViewBinding.atvLeft.setTextColor(leftTextColor)
        val isFinish = typedArray.getBoolean(R.styleable.ProjectView_pv_left_click_finish, false)

        /******************************************center**********************************************************/
        val centerText = typedArray.getString(R.styleable.ProjectView_pv_center_text)
        mViewBinding.atvCenter.text = centerText
        val centerTextSize = typedArray.getDimensionPixelSize(
            R.styleable.ProjectView_pv_center_text_size,
            getDefaultTextSize()
        )
        mViewBinding.atvCenter.setTextSize(TypedValue.COMPLEX_UNIT_PX, centerTextSize.toFloat())
        val centerTextColor =
            typedArray.getColor(R.styleable.ProjectView_pv_center_text_color, Color.BLACK)
        mViewBinding.atvCenter.setTextColor(centerTextColor)
        /******************************************right**********************************************************/
        val rightStartDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_right_start_src)
        val rightTopDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_right_top_src)
        val rightEndDrawable = typedArray.getDrawable(R.styleable.ProjectView_pv_right_end_src)
        val rightBottomDrawable =
            typedArray.getDrawable(R.styleable.ProjectView_pv_right_bottom_src)
        mViewBinding.atvRight.setCompoundDrawablesWithIntrinsicBounds(
            rightStartDrawable,
            rightTopDrawable,
            rightEndDrawable,
            rightBottomDrawable
        )
        val rightParams = mViewBinding.atvRight.layoutParams
        if (rightParams is MarginLayoutParams) {
            rightParams.leftMargin =
                typedArray.getDimensionPixelSize(
                    R.styleable.ProjectView_pv_right_margin_start,
                    Utils.dp2px(context, Contract.DEFAULT_MARGIN.toFloat())
                )
            rightParams.topMargin =
                typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_right_margin_top, 0)
            rightParams.rightMargin =
                typedArray.getDimensionPixelSize(
                    R.styleable.ProjectView_pv_right_margin_end,
                    Utils.dp2px(context, Contract.DEFAULT_MARGIN.toFloat())
                )
            rightParams.bottomMargin =
                typedArray.getDimensionPixelSize(
                    R.styleable.ProjectView_pv_right_margin_bottom,
                    0
                )
            mViewBinding.atvRight.layoutParams = rightParams
        }
        val rightPaddingStart =
            typedArray.getDimensionPixelSize(
                R.styleable.ProjectView_pv_right_padding_start,
                Utils.dp2px(context, Contract.DEFAULT_PADDING.toFloat())
            )
        val rightPaddingTop =
            typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_right_padding_top, 0)
        val rightPaddingEnd =
            typedArray.getDimensionPixelSize(
                R.styleable.ProjectView_pv_right_padding_end,
                Utils.dp2px(context, Contract.DEFAULT_PADDING.toFloat())
            )
        val rightPaddingBottom =
            typedArray.getDimensionPixelSize(
                R.styleable.ProjectView_pv_right_padding_bottom,
                0
            )
        mViewBinding.atvRight.setPadding(
            rightPaddingStart,
            rightPaddingTop,
            rightPaddingEnd,
            rightPaddingBottom
        )
        val rightDrawablePadding =
            typedArray.getDimensionPixelSize(R.styleable.ProjectView_pv_right_drawable_padding, 0)
        mViewBinding.atvRight.compoundDrawablePadding = rightDrawablePadding
        val rightText = typedArray.getString(R.styleable.ProjectView_pv_right_text)
        mViewBinding.atvRight.text = rightText
        val rightTextSize = typedArray.getDimensionPixelSize(
            R.styleable.ProjectView_pv_right_text_size,
            getDefaultTextSize()
        )
        mViewBinding.atvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize.toFloat())
        val rightTextColor =
            typedArray.getColor(R.styleable.ProjectView_pv_right_text_color, Color.BLACK)
        mViewBinding.atvRight.setTextColor(rightTextColor)

        typedArray.recycle()
        mViewBinding.atvLeft.setOnClickListener {
            mOnItemInfoClickListener?.clickLeftView(it)
            if (isFinish && context is Activity) {
                context.setResult(Activity.RESULT_OK)
                context.finish()
            }
        }
        mViewBinding.atvRight.setOnClickListener {
            mOnItemInfoClickListener?.clickRightView(it)
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(
            getSize(widthMeasureSpec, Utils.screenWidth(context)),
            getSize(heightMeasureSpec)
        )

    }

    private fun getSize(measureSpec: Int, defaultSize: Int = getDefaultSize()): Int {
        val size = MeasureSpec.getSize(measureSpec)

        return when (MeasureSpec.getMode(measureSpec)) {
            MeasureSpec.AT_MOST -> {
                val result = size.coerceAtMost(defaultSize)
                val leftParams = mViewBinding.root.layoutParams
                leftParams.height = result
                mViewBinding.root.layoutParams = leftParams
                Log.w("getSize", "$result")
                result

            }
            MeasureSpec.EXACTLY -> {
                size
            }
            else -> {
                defaultSize
            }
        }
    }


    private fun getDefaultSize() =
        Utils.dp2px(context, Contract.DEFAULT_TITLE_HEIGHT_SIZE.toFloat())

    private fun getDefaultTextSize() = Utils.dp2px(context, 14f)
    interface OnItemInfoClickListener {
        fun clickLeftView(view: View)
        fun clickRightView(view: View)
    }
}