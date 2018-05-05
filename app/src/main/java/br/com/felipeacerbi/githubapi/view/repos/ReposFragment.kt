package br.com.felipeacerbi.githubapi.view.repos

import android.app.Fragment
import android.os.Bundle

class ReposFragment : Fragment() {

    companion object {

        private val ARG_LANGUAGE = "language"
        private val ARG_PAGE = "page"

        fun newInstance(language: String, page: Int): ReposFragment {
            val fragment = ReposFragment()
            val args = Bundle()
            args.putString(ARG_LANGUAGE, language)
            args.putInt(ARG_PAGE, page)
            fragment.arguments = args
            return fragment
        }
    }
}
