Code Review Defect List

| Reviewer: Adam Clifton (akclifto) | GH Repo: [**https://github.com/akclifto/asurite-SER316/tree/Review**](https://github.com/akclifto/asurite-SER316/tree/Review) |   |
| --- | --- | --- | ---| ---| 
|   |   |   |  
|   |   |   |
| ID # | Location | Problem Description | Problem |
| File and Line Number | Category | Severity |
| 01 | Main.java, all | No banner information of any kind  | CG 1-3 | LOW |
| 02 | Major.java, all | No banner information of any kind  | CG 1-3 | LOW |
| 03 | Major.java, 3 | Lazy class, only contains constructor, possibly lacks needed majors  | CS 5 | LOW |
| 04 | Student.java, all | No banner information of any kind  | CG 1-3 | LOW |
| 05 | Student.java, 33 | Methods listed out of preferred order, (non-setter/getter method)  | CG 7c | LOW |
| 06 | Student.java, 33 | Inconsistent code style  | CG 8b | LOW |
| 07 | Student.java, 51-53 | Coding style, no brackets { } for if-statements  | CG 8c | LOW |
| 08 | Course.java, all | Missing banner information or not in correct format  | CG 1-3 | LOW |
| 09 | Course.java, 17 | Public attributes  | CG 5 | MJ |
| 10 | Course.java, 18, 32, and 36 | Attribute, Parameter, Method names not in lower camelCase  | CG 4c | LOW |
| 11 | Course.java, 93 | Attribute not listed with the rest of the attributes and public  | CG 7 | MJ |
| 12  | Course.java, 93 | No setter method for private attribute | FD | BR |
| 13 | Course.java, 41, 49, and 94 | Methods listed out of preferred order, (non-setter/getter methods before setters/getters)  | CG 7c-d | LOW |
| 14 | Course.java, 49 | Method name too long  | CS 10 | LOW |
| 15 | Course.java, 103 | Coding style, no brackets { } for if-statements  | CG 8c | LOW |
| 16 |    |   |   |   |

Category:        **CS –** Code Smell defect **. CG –** Violation of a coding guideline. Provide the guideline number. **FD** – Functional defect. Code will not produce the expected result. **MD –** Miscellaneous defect, for all other defects.

Severity:       **BR** - Blocker, must be fixed asap. **MJ** – Major, of high importance but not a Blocker **LOW** – Low.
