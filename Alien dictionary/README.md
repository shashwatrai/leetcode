<h1 _ngcontent-serverapp-c222="" class="problem-title zen-typo-subtitle-small"><a href="https://www.naukri.com/code360/problems/alien-dictionary_630423?leftPanelTabValue=PROBLEM"> Alien dictionary</a> </h1>
<p><br></p>

<p id="write-a-function-that-returns-the-order-of-characters-as-a-string-in-the-alien-language-this-dictionary-will-be-given-to-you-as-an-array-of-strings-called-dictionary-of-size-n">Write a function that returns the order of characters as a string in the alien language. This dictionary will be given to you as an array of strings called <em><strong>'dictionary'</strong></em>, of size <em><strong>'N'</strong></em>.</p>

<p><br></p>

<b id="example">Example :</b>

<pre><code>If the dictionary consists of the following words:-
["caa", "aaa", "aab"], and 'K' is 3.

Then, the order of the alphabet is -
['c', 'a', 'b']
</code></pre>

<b id="note">Note:</b>

<pre><code>If the language consists of four letters, the four letters should be the starting four letters of the English language. 

However, their order might differ in the alien language.
</code></pre>

</div><!----></div><div _ngcontent-serverapp-c225="" class="problem-other-details-container py-8 mt-16 closed ng-star-inserted" style=""><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-section"><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-left-section"><span _ngcontent-serverapp-c225="" class="problem-other-details-text zen-typo-subtitle-small"> Detailed explanation </span><span _ngcontent-serverapp-c225="" class="problem-other-details-subtext zen-typo-caption-medium"> ( Input/output format, Notes, Images ) </span></div><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-right-section"><mat-icon _ngcontent-serverapp-c225="" role="img" fontset="zen-icon" fonticon="icon-chevron-down" class="mat-icon notranslate icon-chevron-down zen-icon mat-icon-no-color" aria-hidden="true" data-mat-icon-type="font" data-mat-icon-name="icon-chevron-down" data-mat-icon-namespace="zen-icon"></mat-icon></div></div><div _ngcontent-serverapp-c225="" disableselect="" imageoverlay="" class="problem-other-details prevent-select" style="display: none;"><b id="input-format">Input format :</b>

<pre><code>The first line contains two integers, 'N' and 'K', representing the alien dictionary's size and the standard dictionary's initial alphabet.

The second line contains 'N' single space-separated strings representing the words in the alien dictionary.
</code></pre>

<b id="output-format">Output Format :</b>

<pre><code>If your order is correct, the output will be true. Otherwise, it will be false.
</code></pre>

<b id="note">Note:</b>

<pre><code>You do not need to print anything; it has already been handled. Just implement the given functions.
</code></pre></div></div><!----><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description mt-16 sample-cases border-radius-8 ng-star-inserted" style=""><b>Sample Input 1 :</b>

<pre><code>3 1
a aa aaa
</code></pre>

<b>Sample Output 1 :</b>

<pre><code>true
</code></pre>

<b>Explanation For Sample Output 1 :</b>

<pre><code>The words are 'a', 'aa', and 'aaa'. Since the unique character here is 'a', the array to be returned will just be ['a']. 

The 'true' being printed signifies that the output returned by the function is valid.
</code></pre>

<b>Sample Input 2 :</b>

<pre><code>3 3
caa aaa aab
</code></pre>

<b>Sample Output 2 :</b>

<pre><code>true
</code></pre>

<b>Constraints :</b>

<pre><code>1 ≤ N ≤ 300
1 ≤ K ≤ 26
1 ≤ Length of words ≤ 50

Time Limit: 1 sec
</code></pre>
</div><!----><!----><!----><!----><!----></div></ninjas-problems-ui-problem-details-tab-description></div>
