# Accessibility in Palette

Palette treats accessibility as a component contract, not as an optional visual review. The design
system provides accessible defaults and reusable guardrails, while applications remain responsible
for validating complete screens, content, navigation and user journeys.

The current baseline is WCAG 2.2 AA interpreted for native mobile interfaces, together with the
Android accessibility guidance. WCAG does not provide a separate mobile standard; platform behavior
and assistive-technology testing are therefore part of the contract.

## Component contract

Every interactive component must define and test:

- an accessible name that describes the purpose in context;
- the correct role, state, value and available actions;
- a logical reading and focus order;
- a touch target of at least 48 x 48 dp;
- a visible state that does not rely on color alone;
- text and layouts that remain usable with enlarged font and display scales;
- localized labels and support for right-to-left layouts;
- predictable behavior with TalkBack, Switch Access, Voice Access and keyboard input.

Every component must also document whether icons and images are informative or decorative. A
decorative graphic uses a `null` content description. An actionable icon receives its label from the
containing control, where the product context is available.

## Palette API guidance

### Icons

`PaletteIcon` is decorative by default. Provide `contentDescription` only when a standalone icon
communicates information that is not already present as text.

`PaletteIconButton` exposes a localized default label. Prefer a contextual `accessibilityLabel` when
the same icon can perform different actions:

```kotlin
PaletteIconButton(
    onClick = onOpenSettings,
    icon = PaletteIconAsset.Settings,
    accessibilityLabel = stringResource(R.string.open_payment_settings)
)
```

### Text and links

Visible text is already exposed to accessibility services. Do not add a duplicate content
description. `PaletteUrlText` uses Compose link annotations, underlining and a minimum 48 dp touch
target; its visible label should describe the destination.

### Loading and status

`PaletteButton` retains its accessible name while loading, exposes a localized state description and
becomes unavailable until the operation completes. Product-level status changes, errors and payment
confirmations must additionally be announced at screen level when they happen outside the focused
control.

### Color

Semantic foreground/background pairs must reach a contrast ratio of at least 4.5:1 for normal text.
The unit test suite checks every Palette semantic pair in light and dark themes. Applications that
override Palette tokens must run equivalent checks for their custom colors.

## Verification layers

1. Unit tests validate token-level invariants such as color contrast.
2. Compose UI tests assert component names, roles, states, actions and structural semantics.
3. Screens are checked at large font/display scales, in light/dark themes and in RTL.
4. Critical journeys are manually completed with TalkBack, Switch Access, Voice Access, keyboard
   input and magnification.
5. Complex or sensitive journeys are tested with people who use assistive technologies.

Automated tests are regression guards; they cannot establish that an application or journey is fully
accessible.

## Pull request checklist

- [ ] Interactive controls have a contextual accessible name.
- [ ] Decorative graphics are hidden from the semantics tree.
- [ ] Dynamic state, progress and errors are announced without excessive interruptions.
- [ ] Focus order follows the visual and task order.
- [ ] Touch targets are at least 48 x 48 dp and do not overlap.
- [ ] Text remains readable and actionable content remains available when enlarged.
- [ ] Information is not communicated by color, position, sound or gesture alone.
- [ ] Light/dark contrast and customized tokens have been tested.
- [ ] Labels are localized and the layout has been checked in RTL.
- [ ] The affected journey has been exercised with the relevant assistive technologies.

## References

- [W3C mobile accessibility](https://www.w3.org/WAI/standards-guidelines/mobile/)
- [WCAG 2.2](https://www.w3.org/TR/WCAG22/)
- [Android accessibility in Compose](https://developer.android.com/develop/ui/compose/accessibility)
- [Android accessibility testing](https://developer.android.com/develop/ui/compose/accessibility/testing)
