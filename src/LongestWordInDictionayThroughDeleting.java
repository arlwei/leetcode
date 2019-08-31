/**
 * titile:
 *   524. Longest Word in Dictionary through Deleting
 *
 *  content:
 *    Given a string and a string dictionary, find the longest string in the dictionary that can be formed 
 *    by deleting some characters of the given string.
 */
class LongestWordInDictionayThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
		String longestTemplate = "";
        for (String template : d) {
			if (template.length() < longestTemplate.length() || 
				(template.length() == longestTemplate.length() && template.compareTo(longestTemplate) >= 0)) {
				continue;
			}
			if (isSubStr(s, template)) {
				longestTemplate = template;
			}
		}
		return longestTemplate;
    }
	
	private boolean isSubStr(String str, String target) {
		int i = 0;
		int j = 0; 
		while (i < str.length() && j < target.length()) {
			if (str.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;
		}
		return j == target.length();
	}
}