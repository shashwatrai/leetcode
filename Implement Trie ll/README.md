<h2><a href="https://www.naukri.com/code360/problems/implement-trie_1387095">Implement Trie ll</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr>
<div _ngcontent-serverapp-c225="" class="problem-description-container pt-16 pb-56"><div _ngcontent-serverapp-c225="" class="problem-statement-title-container"><h2 _ngcontent-serverapp-c225="" class="problem-statement-title zen-typo-subtitle-small"> Problem statement </h2><ninjas-problems-ui-send-feedback-button _ngcontent-serverapp-c225="" _nghost-serverapp-c224=""><div _ngcontent-serverapp-c224=""><button _ngcontent-serverapp-c224="" zen-gray-underlined-text-cta="" size="small" class="zen-base-cta zen-gray-underlined-text-cta zen-cta-base zen-cta-small"><span class="zen-cta-wrapper"><span _ngcontent-serverapp-c224=""> Send feedback </span></span></button></div></ninjas-problems-ui-send-feedback-button></div><div _ngcontent-serverapp-c225="" class="problem-main-statement ng-star-inserted" style=""><div _ngcontent-serverapp-c225="" imageoverlay="" class="description pt-8 problem-statement ng-star-inserted"><p id="ninja-has-to-implement-a-data-structure-trie-from-scratch-ninja-has-to-complete-some-functions">Ninja has to implement a data structure ”TRIE” from scratch. Ninja has to complete some functions.</p>

<pre><code>1) Trie(): Ninja has to initialize the object of this “TRIE” data structure.

2) insert(“WORD”): Ninja has to insert the string “WORD”  into this “TRIE” data structure.

3) countWordsEqualTo(“WORD”): Ninja has to return how many times this “WORD” is present in this “TRIE”.

4) countWordsStartingWith(“PREFIX”): Ninjas have to return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.

5) erase(“WORD”): Ninja has to delete one occurrence of the string “WORD” from the “TRIE”.
</code></pre>

<p id="note">Note:</p>

<pre><code>1. If erase(“WORD”) function is called then it is guaranteed that the “WORD” is present in the “TRIE”.

2. If you are going to use variables with dynamic memory allocation then you need to release the memory associated with them at the end of your solution.
</code></pre>

<p id="can-you-help-ninja-implement-the-trie-data-structure">Can you help Ninja implement the "TRIE" data structure?</p>

</div><!----></div><div _ngcontent-serverapp-c225="" class="problem-other-details-container py-8 mt-16 closed ng-star-inserted" style=""><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-section"><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-left-section"><span _ngcontent-serverapp-c225="" class="problem-other-details-text zen-typo-subtitle-small"> Detailed explanation </span><span _ngcontent-serverapp-c225="" class="problem-other-details-subtext zen-typo-caption-medium"> ( Input/output format, Notes, Images ) </span></div><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-right-section"><mat-icon _ngcontent-serverapp-c225="" role="img" fontset="zen-icon" fonticon="icon-chevron-down" class="mat-icon notranslate icon-chevron-down zen-icon mat-icon-no-color" aria-hidden="true" data-mat-icon-type="font" data-mat-icon-name="icon-chevron-down" data-mat-icon-namespace="zen-icon"></mat-icon></div></div><div _ngcontent-serverapp-c225="" disableselect="" imageoverlay="" class="problem-other-details prevent-select" style="display: none;"><b id="input-format">Input Format:</b>

<pre><code>The first line contains a single integer “T” representing the number of test cases. 

The first line of each test case will contain a single integer “N” which denotes how many times the functions(as discussed above) will be called.

The next “N” lines contain the two space-separated strings, the first one is the name of the function and the second one is a “WORD”.
</code></pre>

<b id="output-format">Output Format:</b>

<pre><code>For each test case, complete all the functions as we discussed above.

The output for every test case will be printed in a separate line.
</code></pre>

<p id="note">Note:</p>

<pre><code>You do not need to print anything; it has already been taken care of. Just implement the given function.
</code></pre></div></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description pt-8 ng-star-inserted" style=""><b id="constraints">Constraints:</b>

<pre><code>1 &lt;= “T” &lt;= 50
1 &lt;= “N” &lt;= 10000
 “WORD” = {a to z}
1 &lt;= | “WORD” | &lt;= 1000

Where “T” is the number of test cases, “N” denotes how many times the functions(as discussed above) we call, “WORD” denotes the string on which we have to perform all the operations as we discussed above, and | “WORD” | denotes the length of the string “WORD”.

Time limit: 1 sec.
</code></pre></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description mt-16 sample-cases border-radius-8 ng-star-inserted" style=""><h5>Sample Input 1:</h5>

<pre><code>1
5
insert coding
insert ninja
countWordsEqualTo coding
countWordsStartingWith nin
erase coding
</code></pre>

<h5>Sample Output 1:</h5>

<pre><code>1
1   
</code></pre>

<h5>Explanation of sample input 1:</h5>

<pre><code>After insertion of “coding” in “TRIE”:
</code></pre>

<p><img src="https://files.codingninjas.in/trieex1-8873.png" alt=""></p>

<pre><code>After insertion of “ninja” in “TRIE”:
</code></pre>

<p><img src="https://files.codingninjas.in/trieex1_2-8872.png" alt=""></p>

<pre><code>Count words equal to “coding” :
</code></pre>

<p><img src="https://files.codingninjas.in/trieex3-8871.png" alt=""></p>

<pre><code>Count words those prefix is “nin”:
</code></pre>

<p><img src="https://files.codingninjas.in/trieex4-8870.png" alt=""></p>

<pre><code>After deletion of the word “coding”, “TRIE” is:
</code></pre>

<p><img src="https://files.codingninjas.in/trieex1-5-8869.png" alt=""></p>

<h5>Sample Input 2:</h5>

<pre><code>1
6
insert samsung
insert samsung
insert vivo
erase vivo
countWordsEqualTo samsung
countWordsStartingWith vi
</code></pre>

<h5>Sample Output 2:</h5>

<pre><code>2
0
</code></pre>

<h5>Explanation for sample input 2:</h5>

<pre><code>insert “samsung”: we are going to insert the word “samsung” into the “TRIE”.

insert “samsung”: we are going to insert another “samsung” word into the “TRIE”.

insert “vivo”: we are going to insert the word “vivo” into the “TRIE”.

erase “vivo”: we are going to delete the word “vivo” from the “TRIE”.

countWordsEqualTo “samsung”: There are two instances of “sumsung” is present in “TRIE”.

countWordsStartingWith “vi”: There is not a single word in the “TRIE” that starts from the prefix “vi”.
</code></pre>
</div><!----><!----><!----><!----><!----></div>
