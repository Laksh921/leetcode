// Last updated: 3/22/2025, 12:04:06 AM
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> numberOfSuppliesNeeded = new HashMap<>();
        Map<String, List<String>> dependencyonIngredient = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        for(int i=0; i<recipes.length;i++){
            String recipe = recipes[i];
            numberOfSuppliesNeeded.put(recipe,ingredients.get(i).size());
            for(String ingredient : ingredients.get(i)){
                dependencyonIngredient.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(available);
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            String ingredient = queue.poll();
            if(!dependencyonIngredient.containsKey(ingredient)) continue;
            for(String recipe : dependencyonIngredient.get(ingredient)){
                numberOfSuppliesNeeded.put(recipe, numberOfSuppliesNeeded.get(recipe)-1);
                if(numberOfSuppliesNeeded.get(recipe) == 0){
                    result.add(recipe);
                    queue.offer(recipe);
                }
            }
        } 
        return result;
    }
}