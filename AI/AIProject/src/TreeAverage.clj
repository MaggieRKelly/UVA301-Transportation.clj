(defn sum-tree [tree]
  (cond
    (number? tree)  tree                               ;Check if pulled value is a number, then passes the tree again
    (not (seq  tree))  0                                  ;If pulled value is empty add 0
    :else
    (+ (sum-tree (first tree)) (sum-tree (rest tree))) ;Otherwise add the first to the tree to the last of the tree
    ))

(defn count-tree [tree]
  (cond
    (nil? tree) 0
    (not (coll? tree)) 1                                     ;returns true if x implements a persistent collection eg (coll '()) = true but (coll 4) = false
    ;Checks that its not one of them, so it means its a number. It will then add 1
    (empty? tree) 0                                          ;If the pulled element is empty add 0
    :else
    (+ (count-tree (first tree)) (count-tree (rest tree))))) ;Add the first node of tree, (current branch)
;Recur through the rest of the tree

(defn nested-average-v2 [tree]                   ;define function takes sequence as argument
  (/ (reduce + (flatten tree))(count (flatten tree))))  ;divide the total of the flattened tree by the number of elements in the flattened tree

;Why doesnt this work?
(defn nested-average-v3 [tree]
  (cond
    (number? tree)  tree
    (not (seq  tree))  0
    :else
    (/ (reduce + (map nested-average-v3 tree)) (count (map nested-average-v3 tree)))))


(defn method-tree-average [tree]
  (/ (sum-tree [tree]) (count-tree [tree])))  ;Uses the already created methods to find the average


;Create helper function to check against all the values
;pass in a tree, pass in a tree and the "count", check the tree, add the valeus then divide by the "count"

(defn tree-average
  ([tree] (tree-average tree 0))
  ([tree n]
   (cond
     (number? tree)  tree                               ;Checks against tree
     (empty?  tree)  0
     (nil? tree) 0
     (not (coll? tree)) 1
     :else
     (+ (sum-tree (first tree)) (sum-tree (rest tree)) (inc n)) ;Otherwise add the first to the tree to the last of the tree
     )))

;--- TO DO LIST ---
;Create a function that gets the sum and the count in 1 (then divides them)
;Find a tail recursive way for sum-tree and count-tree
;Use recur with the tail functions. (test times)
;Create a method that uses the both of the tail recursive methods
;------------------