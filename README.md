# Palette 🎨

Palette is an open-source design system for Android built with Jetpack Compose. It demonstrates a structured, atomic approach to UI design by providing a collection of design tokens, reusable components, patterns, blocks, and templates. Palette is intended as a reference implementation to help developers understand how to organize and apply design principles consistently in their projects.

## Material 3 Integration

Palette tokens for colors, typography, and shapes are fully mapped to Material 3 standards. For example:
- **Colors:** Adaptive Palette colors convert to Material 3 color schemes, ensuring proper usage for primary, background, and other roles.
- **Typography:** Predefined text styles (via PaletteTextStyle) integrate seamlessly with Material 3 typography for consistent text presentation.
- **Shapes:** Palette shape tokens are used to generate Material 3 shapes for UI elements such as cards, buttons, and app bars.

## What's Inside

### Design Tokens (Atoms)
- **Colors:** Adaptive color tokens for both light and dark themes.
- **Typography:** A set of predefined text styles (restricted via a sealed class) to ensure consistency.
- **Dimensions:** Type-safe spacing, icon sizes, and corner radii defined centrally in `PaletteDimension`.
- **Shapes:** Standard shape tokens for UI components provided in `PaletteShapeSystem`.
- **Icons:** An icon asset system (`PaletteIconAsset`) that supports both custom icons and Material icons.

### Components (Molecules)
- **PaletteText:** A text component that enforces the predefined typography tokens.
- **PaletteButton:** A customizable button that applies design tokens for color, spacing, and shape.
- **PaletteImage:** An image component that supports both drawable resources and URL loading (via Coil), with optional outline support.
- **PaletteIcon & PaletteIconButton:** Components for rendering icons with type-safe sizing and proper click behavior.

### Patterns (Organisms)
- **PaletteTopAppBar:** A top app bar pattern that integrates a title and navigation actions.
- **PaletteContentBlock:** A composite block that displays an image, title, description, and an optional action button.

### Templates (Pages)
- **PaletteErrorScreenTemplate:** A full-page error screen template that assembles the top app bar and content block into a cohesive layout with a retry action.

## Additional Resources

For further insights into the design principles behind Palette, watch this talk on YouTube about:  
[![Accent Design System Talk](https://img.youtube.com/vi/KF3murFG5-8/0.jpg)](https://www.youtube.com/watch?v=KF3murFG5-8)

## Getting Started

Palette is provided as a reference implementation. Explore the code to see how design tokens and reusable components are combined to create consistent and maintainable UI patterns. Contributions, feedback, and suggestions are welcome.

## TODO / Roadmap

- [ ] Publish Palette to Maven Central
- [ ] Develop a simple demo app that showcases different Palette items (components, patterns, blocks, templates) in various configurations
- [ ] Set up basic CI for build verification and testing
- [ ] Create a CONTRIBUTING guide for community contributions
