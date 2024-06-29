<h1 _ngcontent-serverapp-c222="" class="problem-title zen-typo-subtitle-small"> <a href="https://www.naukri.com/code360/problems/complete-string_2687860"> Complete String </a></h1>
<p id="a-string-is-called-a-complete-string-if-every-prefix-of-this-string-is-also-present-in-the-array-a-ninja-is-challenged-to-find-the-longest-complete-string-in-the-array-a-if-there-are-multiple-strings-with-the-same-length-return-the-lexicographically-smallest-one-and-if-no-string-exists-return-none">A string is called a complete string if every prefix of this string is also present in the array ‘A’. Ninja is challenged to find the longest complete string in the array ‘A’.If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None".</p>

<b id="note">Note :</b>

<pre><code>String ‘P’ is lexicographically smaller than string ‘Q’, if : 

1. There exists some index ‘i’ such that for all ‘j’ &lt; ‘i’ , ‘P[j] = Q[j]’ and ‘P[i] &lt; Q[i]’. E.g. “ninja” &lt; “noder”.

2. If ‘P’ is a prefix of string ‘Q’, e.g. “code” &lt; “coder”.
</code></pre>

<b id="example">Example :</b>

<pre><code>N = 4
A = [ “ab” , “abc” , “a” , “bp” ] 

Explanation : 

Only prefix of the string “a” is “a” which is present in array ‘A’. So, it is one of the possible strings.

Prefixes of the string “ab” are “a” and “ab” both of which are present in array ‘A’. So, it is one of the possible strings.

Prefixes of the string “bp” are “b” and “bp”. “b” is not present in array ‘A’. So, it cannot be a valid string.

Prefixes of the string “abc” are “a”,“ab” and “abc” all of which are present in array ‘A’. So, it is one of the possible strings.

We need to find the maximum length string, so “abc” is the required string.
</code></pre>

</div><!----></div><div _ngcontent-serverapp-c225="" class="problem-other-details-container py-8 mt-16 closed ng-star-inserted" style=""><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-section"><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-left-section"><span _ngcontent-serverapp-c225="" class="problem-other-details-text zen-typo-subtitle-small"> Detailed explanation </span><span _ngcontent-serverapp-c225="" class="problem-other-details-subtext zen-typo-caption-medium"> ( Input/output format, Notes, Images ) </span></div><div _ngcontent-serverapp-c225="" class="problem-other-details-heading-right-section"><mat-icon _ngcontent-serverapp-c225="" role="img" fontset="zen-icon" fonticon="icon-chevron-down" class="mat-icon notranslate icon-chevron-down zen-icon mat-icon-no-color" aria-hidden="true" data-mat-icon-type="font" data-mat-icon-name="icon-chevron-down" data-mat-icon-namespace="zen-icon"></mat-icon></div></div><div _ngcontent-serverapp-c225="" disableselect="" imageoverlay="" class="problem-other-details prevent-select" style="display: none;"><b id="input-format">Input Format :</b>

<pre><code>The first line contains an integer 'T' which denotes the number of test cases to be run. Then the test cases follow.

The second line of each test case contains an integer ‘N’ denoting the size of array ‘A’.

The third line of each test case contains ‘N’ space-separated strings denoting the elements of array ‘A’.
</code></pre>

<b id="output-format">Output format :</b>

<pre><code>For each test case, print the longest string in ‘A’, such that every prefix of this string is also present in the array ‘A’. If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None" as answer.

Print the output of each test case in a new line.
</code></pre>

<b id="note">Note :</b>

<pre><code>You don’t need to print anything. It has already been taken care of. Just implement the given function.
</code></pre></div></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description pt-8 ng-star-inserted" style=""><b id="constraints">Constraints :</b>

<pre><code>1 &lt;= T &lt;= 10
1 &lt;= N &lt;= 10^5
1 &lt;= A[i].length &lt;= 10^5
A[i] only consists of lowercase english letters.
Sum of A[i].length &lt;= 10^5 over all test cases

Time Limit : 1 sec
</code></pre></div><!----><div _ngcontent-serverapp-c225="" imageoverlay="" class="description mt-16 sample-cases border-radius-8 ng-star-inserted" style=""><b>Sample Input 1 :</b>

<pre><code>2
6
n ni nin ninj ninja ninga
2
ab bc
</code></pre>

<b>Sample Output 1 :</b>

<pre><code>ninja
None
</code></pre>

<b>Explanation Of Sample Input 1 :</b>

<pre><code>For test case 1 we have, 

All the prefixes of “ninja” -&gt; “n”, “ni”, “nin”, “ninj” and “ninja” are present in array ‘A’. So, “ninja” is a valid answer whereas for “ninga” , the prefix “ning” is not present in array ‘A’.

So we output “ninja”.

For test case 2 we have, 

The prefixes of “ab” are “a” and “ab”. “a” is not present in array ‘A’. So, “ab” is not a valid answer.

The prefixes of “bc” are “b” and “bc”. “b” is not present in array ‘A’. So, “ab” is not a valid answer.

Since none of the strings is a valid answer we output “None”.
</code></pre>

<b>Sample Input 2 :</b>

<pre><code>2
5
g a ak szhkb hy 
4
kez vfj vfjq vfjqo 
</code></pre>

<b>Sample Output 2 :</b>

<pre><code>ak
None
</code></pre>
</div><!----><!----><!----><!----><!----></div></ninjas-problems-ui-problem-details-tab-description></div><!----></ninjas-problems-ui-problem-details-tab><!----></div>
