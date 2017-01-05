# tab_layout_sample
Sample app demonstrating the broken TabLayout behavior

This demonstrates a subtle bug in support library 25.1.0. There are two different behaviors here:
1) Under 25.0.1 - the fragments receive onHiddenChanged in the order of the transaction, so the newly visible fragment receives onHiddenChanged *last*.
2) Under 25.1.0 - the fragments receive onHiddenChanged in the order they are added to the activity. So Fragment 1 always receives onHiddenChanged before Fragment 2.
