/**
 * Defines the TagCloud API for generating visual word clouds.
 * <p>
 * This module provides the core engines for tag cloud generation,
 * including various color and font providers to customize the visual output.
 * </p>
 * * @author Richard Eigenmann
 */

module org.tagcloud {
    requires java.desktop;
    requires java.logging;
    exports org.tagcloud;
    exports org.tagcloud.colorproviders;
    exports org.tagcloud.fontproviders;
}