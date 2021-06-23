package kz.das.dasaccounting.ui.office.accept

import android.os.Bundle
import androidx.lifecycle.Observer
import kz.das.dasaccounting.R
import kz.das.dasaccounting.core.navigation.DasAppScreen
import kz.das.dasaccounting.core.ui.fragments.BaseFragment
import kz.das.dasaccounting.databinding.FragmentInventoryAcceptConfirmationBinding
import kz.das.dasaccounting.domain.data.office.OfficeInventory
import org.koin.android.viewmodel.ext.android.viewModel

class AcceptConfirmationFragment : BaseFragment<AcceptConfirmationVM, FragmentInventoryAcceptConfirmationBinding>() {

    companion object {
        private const val OFFICE_INVENTORY = "inventory"

        fun getScreen(officeInventoryAccept: OfficeInventory) = DasAppScreen(AcceptConfirmationFragment()).apply {
            val args = Bundle()
            args.putParcelable(OFFICE_INVENTORY, officeInventoryAccept)
            this.setArgs(args)
        }
    }

    override val mViewModel: AcceptConfirmationVM by viewModel()

    override fun getViewBinding() = FragmentInventoryAcceptConfirmationBinding.inflate(layoutInflater)

    override fun setupUI() {
        mViewModel.setOfficeInventory(getOfficeInventory())

        mViewBinding.apply {
            btnReady.setOnClickListener {
                mViewModel.acceptInventory(mViewBinding.edtComment.text.toString() ?: "")
            }
        }
    }

    override fun observeLiveData() {
        super.observeLiveData()

        mViewModel.getOfficeInventory().observe(viewLifecycleOwner, Observer {

        })

        mViewModel.isOfficeInventoryAccepted().observe(viewLifecycleOwner, Observer {
            if (it) {
                showSuccess(getString(R.string.common_banner_success),
                    getString(R.string.office_inventory_accepted_successfully))
            }
        })
    }

    private fun initViews() {
        mViewModel.getOfficeInventory().observe(viewLifecycleOwner, Observer {
            it?.let {
                mViewBinding.ivInventory.setImageResource(R.drawable.ic_inventory)
                mViewBinding.tvInventoryTitle.text = it.name
                mViewBinding.tvInventoryDesc.text =
                    (getString(R.string.inventory_total_quantity) +
                            " " + it.quantity +
                            " " + it.type + "\n" +
                            String.format(getString(R.string.inventory_sender_name), it.senderName))
            }
        })
    }

    private fun getOfficeInventory(): OfficeInventory? {
        return arguments?.getParcelable(OFFICE_INVENTORY)
    }
}