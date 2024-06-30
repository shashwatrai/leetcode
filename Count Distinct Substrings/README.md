<h1 _ngcontent-serverapp-c222="" class="problem-title zen-typo-subtitle-small"><a href="https://www.naukri.com/code360/problems/count-distinct-substrings_985292"> Count Distinct Substrings </a></h1>
<b id="note">Note :</b>

<pre><code>A string ‘B’ is a substring of a string ‘A’ if ‘B’ that can be obtained by deletion of, several characters(possibly none) from the start of ‘A’ and several characters(possibly none) from the end of ‘A’. 

Two strings ‘X’ and ‘Y’ are considered different if there is at least one index ‘i’  such that the character of ‘X’ at index ‘i’ is different from the character of ‘Y’ at index ‘i’(X[i]!=Y[i]).
</code></pre>

</div><!----></div><div _ngcontent-serverapp-c225="" class="problem-other-details-container py-8 mt-16 closed ng-star-inserted" style=""><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-section"><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-left-section"><span _ngcontent-serverapp-c225="" class="problem-other-details-text zen-typo-subtitle-small"> Detailed explanation </span><span _ngcontent-serverapp-c225="" class="problem-other-details-subtext zen-typo-caption-medium"> ( Input/output format, Notes, Images ) </span></div><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-right-section"><mat-icon _ngcontent-serverapp-c225="" role="img" fontset="zen-icon" fonticon="icon-chevron-down" class="mat-icon notranslate icon-chevron-down zen-icon mat-icon-no-color" aria-hidden="true" data-mat-icon-type="font" data-mat-icon-name="icon-chevron-down" data-mat-icon-namespace="zen-icon"></mat-icon></div></div><div _ngcontent-serverapp-c225="" disableselect="" imageoverlay="" class="problem-other-details prevent-select" style="display: none;"><b id="input-format">Input Format :</b>

<pre><code>The first line contains a single integer ‘T’ denoting the number of test cases.

Then, the ‘T’ test cases follow.

The first line of each test case contains a string.
</code></pre>

<b id="output-format">Output Format :</b>

<pre><code>For each test case, print an integer denoting the number of distinct substrings in the given string.

The output for each test case will be printed in a separate line.
</code></pre>

<b id="note">Note :</b>

<pre><code>You don’t need to print anything, It has already been taken care of. Just implement the given function.
</code></pre></div></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description pt-8 ng-star-inserted" style=""><b id="constraints">Constraints :</b>

<pre><code>1 &lt;= T &lt;= 5
1 &lt;= |S| &lt;= 10^3

‘S’ contains only lowercase English letters.

Time Limit: 1 sec
</code></pre></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description mt-16 sample-cases border-radius-8 ng-star-inserted" style=""><h5>Sample Input 1 :</h5>

<pre><code>2
sds
abc
</code></pre>

<h5>Sample Output 1 :</h5>

<pre><code>6
7
</code></pre>

<h5>Explanation of Sample Input 1 :</h5>

<pre><code>In the first test case, the 6 distinct substrings are { ‘s’,’ d’, ”sd”, ”ds”, ”sds”, “” }

In the second test case, the 7 distinct substrings are {‘a’, ‘b’, ‘c’, “ab”, “bc”, “abc”, “” }.
</code></pre>

<h5>Sample Input 2 :</h5>

<pre><code>2
aa
abab
</code></pre>

<h5>Sample Output 2 :</h5>

<pre><code>3
8
</code></pre>

<h5>Explanation of Sample Input 2 :</h5>

<pre><code>In the first test case, the two distinct substrings are {‘a’, “aa”, “” }.

In the second test case, the seven distinct substrings are {‘a’, ‘b’, “ab”, “ba”, “aba”, “bab”, “abab”, “” }
</code></pre>

<p><br></p>

<h5>Hints:</h5>

<pre><code>1. Can you think about a data structure that can be used to store the distinct substrings?
2. Can you think about using the fact that every substring of ‘S’ is a prefix of some suffix string of ‘S’?
3. Try to insert every suffix of the string in Trie.
</code></pre>
</div><!----><!----><!----><!----><!----></div></ninjas-problems-ui-problem-details-tab-description></div><!----></ninjas-problems-ui-problem-details-tab><!----></div></div>
