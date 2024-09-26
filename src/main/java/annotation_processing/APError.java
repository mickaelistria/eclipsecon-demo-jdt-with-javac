package annotation_processing;

import com.google.auto.value.AutoValue;

/**
 * Demo ECJ failure for annotation processing.
 * 
 * https://github.com/redhat-developer/vscode-java/issues/3223 and
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=547970
 * 
 * Edit the file and save to trigger the AbortCompilation exception.
 */
@AutoValue
public abstract class APError<T> {
	@AutoValue
	public abstract static class Nested<T> {
		public abstract T data();
	}

	@AutoValue.Builder
	public abstract static class Builder<T> {
		public abstract Builder<T> nested(Nested<T> nested);
		public abstract APError<T> build();
	}

	public abstract Nested<T> nested();
}
