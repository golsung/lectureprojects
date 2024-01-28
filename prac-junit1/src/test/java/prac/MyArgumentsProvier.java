package prac;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MyArgumentsProvier implements ArgumentsProvider {
	
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext arg0) throws Exception {
		return Stream.of(
                Arguments.of(-10, 90, 95),
                Arguments.of(110, 0, 70),
                Arguments.of(80, -90, 95),
                Arguments.of(80, 120, 55),
                Arguments.of(80, 90, -20),                
                Arguments.of(80, 70, 150)
        );
	}
}
