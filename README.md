# MythicMobs BreweryX Addon

A seamless integration addon that brings **MythicMobs** item support to **BreweryX** brewing recipes. Create custom alcoholic beverages using your favorite MythicMobs items as ingredients!

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![BreweryX](https://img.shields.io/badge/BreweryX-3.6.0-blue.svg)](https://github.com/BreweryTeam/BreweryX)
[![MythicMobs](https://img.shields.io/badge/MythicMobs-5.4.0+-purple.svg)](https://mythiccraft.io/)

## 🔔 Notice

[TheBrewingProject](https://github.com/BreweryTeam/TheBrewingProject) has already been added native support of the MythicMobs(-Crucible) items. I recommend switching to this plugin, but still this addon is supported (although I haven't received any complaints about bugs yet, hehe), at least until BreweryX stops getting support.

## 🍺 Features

- **Native Integration**: Use MythicMobs items directly in BreweryX recipes with the `mythic:` prefix
- **Automatic Detection**: Automatically detects and validates MythicMobs items
- **Smart Matching**: Intelligent item comparison system that works with MythicMobs' custom NBT data
- **Performance Optimized**: Lightweight addon with minimal performance impact
- **Error Handling**: Comprehensive error handling and logging for debugging
- **Plug & Play**: Simple installation with automatic dependency detection

## 📋 Tested with

- **Minecraft**: 1.21.8 (Paper)
- **Java**: 21
- **BreweryX**: 3.6.0
- **MythicMobs**: 5.11.0-SNAPSHOT
- **MythicCrucible**: 2.2.0-SNAPSHOT

## 🚀 Installation

1. Download the latest release from the [Releases](https://github.com/Andromedov/MythicMobs-BreweryX-Addon/releases) page
2. Place the `.jar` file in your `/plugins/BreweryX/addons/` directory
3. Restart your server
4. The addon will automatically detect MythicMobs and enable support

## 📖 Usage

### Basic Syntax

Use MythicMobs items in your BreweryX recipes with the following format:

```yaml
- mythic:ITEM_ID/AMOUNT
 ```

### Recipe Example

```yaml
recipes:
  magical_wine:
    name: "Bad Wine/Wine/Good Wine"
    ingredients:
    - mythic:EnchantedCorn/20    # 20 Enchanted Corn from MythicMobs
    - mythic:MysticBread/5         # 5 Mystic Bread from MythicMobs
    - Sugar/10                     # 10 regular Sugar
    cookingtime: 8
    distillruns: 2
    distilltime: 30
    color: 8B00FF
    difficulty: 3
    alcohol: 7
    lore:
    - "A wine brewed with magical ingredients"
    - "Grants mystical powers to those who drink it"
    effects:
    - REGENERATION/1-2/60-120
```

## ⚙️ Configuration

The addon automatically configures itself. However, you can verify it's working by checking the server console during startup:

```
[BreweryX] [MythicMobsBreweryXAddon] Loading MythicMobsBreweryXAddon - v1.0 by Andromedov
[BreweryX] [MythicMobsBreweryXAddon] MythicMobs support enabled!
[BreweryX] [MythicMobsBreweryXAddon] Registered 'mythic' prefix for PluginItem
```

## 🐛 Troubleshooting

### Common Issues

**Plugin item not found**
- Ensure the MythicMobs item ID exists in your MythicMobs configuration
- Check that the item ID is spelled correctly (case-sensitive)
- Verify MythicMobs is properly loaded before BreweryX

**Items not matching during brewing**
- Ensure the MythicMobs items have the correct NBT data
- Check that the item amounts match your recipe requirements

### Getting Help

1. Check the [Issues](https://github.com/Andromedov/MythicMobs-BreweryX-Addon/issues) page for similar problems
2. Create a new issue with:
   - Your server version
   - BreweryX version
   - MythicMobs version
   - Full error logs
   - Your recipe configuration

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### Development Setup

1. Clone the repository
2. Ensure you have BreweryX and MythicMobs APIs available
3. Build using `./gradlew clean build`

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **BreweryTeam** - For creating the amazing BreweryX plugin and addon API
- **MythicCraft** - For the powerful MythicMobs plugin
