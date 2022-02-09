package nl.han.ica.oose.dea;


import nl.han.ica.oose.dea.helpers.Product;
import nl.han.ica.oose.dea.helpers.ProductCategory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streams {

    List<String> filterStringsShorterThanThreeCharacters(List<String> input) {
        return input.stream()
                .filter(s -> s.length()<3)
                .collect(Collectors.toList());

    }

    List<String> filterStringsThatContainOnlyNumerals(List<String> input) {
        return input.stream()
                .filter(s -> s.chars().allMatch(c -> Character.isDigit(c)))
                .collect(Collectors.toList());

    }

    String findShortestString(List<String> input) {
        return input.stream()
                .min(Comparator.comparingInt(s -> s.length()))
                .orElse(null);
    }

    String createAFullSentenceFromTheList(List<String> input) {
        return input.stream()
                .collect(Collectors.joining(" "));
    }

    int calculateTotalCostOfAllProducts(List<Product> products) {
        return products.stream()
                .mapToInt(p -> p.getPrice())
                .sum();
    }

    int calculateTotalCostOfAllGadgets(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals(ProductCategory.GADGETS))
                .mapToInt(p -> p.getPrice())
                .sum();
    }
}
