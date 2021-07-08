package com.raphael.conhecame

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(gerenciador: FragmentManager):
    FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int{
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            Fragment1()
        else if (position == 1)
            Fragment2()
        else if (position == 2)
            Fragment3()
        else
            Fragment4()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Sobre"
        else if (position == 1)
            "Formação"
        else if (position == 2)
            "Experiência"
        else
            "Diferencias"
    }

}