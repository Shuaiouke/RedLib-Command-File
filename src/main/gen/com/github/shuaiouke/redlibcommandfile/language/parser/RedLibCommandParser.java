// This is a generated file. Not intended for manual editing.
package com.github.shuaiouke.redlibcommandfile.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.shuaiouke.redlibcommandfile.language.psi.RedLibCommandTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RedLibCommandParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // assert separator assertname (SPACE assertname)
  public static boolean AssertLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssertLine")) return false;
    if (!nextTokenIs(b, ASSERT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSERT_LINE, null);
    r = consumeTokens(b, 2, ASSERT, SEPARATOR, ASSERTNAME);
    p = r; // pin = 2
    r = r && AssertLine_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SPACE assertname
  private static boolean AssertLine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssertLine_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, ASSERTNAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '}' (newline|<<eof>>)
  public static boolean Close_Bracket(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Close_Bracket")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLOSE_BRACKET, "<close bracket>");
    r = consumeToken(b, "}");
    r = r && Close_Bracket_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline|<<eof>>
  private static boolean Close_Bracket_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Close_Bracket_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // commandname (aliasseparator alias)* (SPACE|newline)* Open_Bracket (CommandProperty | CommandDefinition | newline)* Close_Bracket
  public static boolean CommandDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition")) return false;
    if (!nextTokenIs(b, COMMANDNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMANDNAME);
    r = r && CommandDefinition_1(b, l + 1);
    r = r && CommandDefinition_2(b, l + 1);
    r = r && Open_Bracket(b, l + 1);
    r = r && CommandDefinition_4(b, l + 1);
    r = r && Close_Bracket(b, l + 1);
    exit_section_(b, m, COMMAND_DEFINITION, r);
    return r;
  }

  // (aliasseparator alias)*
  private static boolean CommandDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CommandDefinition_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CommandDefinition_1", c)) break;
    }
    return true;
  }

  // aliasseparator alias
  private static boolean CommandDefinition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIASSEPARATOR, ALIAS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SPACE|newline)*
  private static boolean CommandDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CommandDefinition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CommandDefinition_2", c)) break;
    }
    return true;
  }

  // SPACE|newline
  private static boolean CommandDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_2_0")) return false;
    boolean r;
    r = consumeToken(b, SPACE);
    if (!r) r = consumeToken(b, NEWLINE);
    return r;
  }

  // (CommandProperty | CommandDefinition | newline)*
  private static boolean CommandDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CommandDefinition_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CommandDefinition_4", c)) break;
    }
    return true;
  }

  // CommandProperty | CommandDefinition | newline
  private static boolean CommandDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandDefinition_4_0")) return false;
    boolean r;
    r = CommandProperty(b, l + 1);
    if (!r) r = CommandDefinition(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    return r;
  }

  /* ********************************************************** */
  // (HelpLine|PermissionLine|UserLine|HookLine|ContextLine|AssertLine|NoHelpLine|NoTabLine|PostArgLine) newline
  public static boolean CommandProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_PROPERTY, "<command property>");
    r = CommandProperty_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HelpLine|PermissionLine|UserLine|HookLine|ContextLine|AssertLine|NoHelpLine|NoTabLine|PostArgLine
  private static boolean CommandProperty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandProperty_0")) return false;
    boolean r;
    r = HelpLine(b, l + 1);
    if (!r) r = PermissionLine(b, l + 1);
    if (!r) r = UserLine(b, l + 1);
    if (!r) r = HookLine(b, l + 1);
    if (!r) r = ContextLine(b, l + 1);
    if (!r) r = AssertLine(b, l + 1);
    if (!r) r = NoHelpLine(b, l + 1);
    if (!r) r = NoTabLine(b, l + 1);
    if (!r) r = PostArgLine(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // context separator contextname (SPACE contextname)
  public static boolean ContextLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContextLine")) return false;
    if (!nextTokenIs(b, CONTEXT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT_LINE, null);
    r = consumeTokens(b, 2, CONTEXT, SEPARATOR, CONTEXTNAME);
    p = r; // pin = 2
    r = r && ContextLine_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SPACE contextname
  private static boolean ContextLine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContextLine_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, CONTEXTNAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // help separator helpmessage (SPACE helpmessage)*
  public static boolean HelpLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HelpLine")) return false;
    if (!nextTokenIs(b, HELP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, HELP_LINE, null);
    r = consumeTokens(b, 2, HELP, SEPARATOR, HELPMESSAGE);
    p = r; // pin = 2
    r = r && HelpLine_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (SPACE helpmessage)*
  private static boolean HelpLine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HelpLine_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!HelpLine_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "HelpLine_3", c)) break;
    }
    return true;
  }

  // SPACE helpmessage
  private static boolean HelpLine_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HelpLine_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SPACE, HELPMESSAGE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // hook separator hookname
  public static boolean HookLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HookLine")) return false;
    if (!nextTokenIs(b, HOOK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, HOOK_LINE, null);
    r = consumeTokens(b, 2, HOOK, SEPARATOR, HOOKNAME);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // nohelp
  public static boolean NoHelpLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NoHelpLine")) return false;
    if (!nextTokenIs(b, NOHELP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOHELP);
    exit_section_(b, m, NO_HELP_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // notab
  public static boolean NoTabLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NoTabLine")) return false;
    if (!nextTokenIs(b, NOTAB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOTAB);
    exit_section_(b, m, NO_TAB_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // OBRACKET newline
  public static boolean Open_Bracket(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Open_Bracket")) return false;
    if (!nextTokenIs(b, OBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OBRACKET, NEWLINE);
    exit_section_(b, m, OPEN_BRACKET, r);
    return r;
  }

  /* ********************************************************** */
  // permission separator PERMISSION_VALUE (DOT PERMISSION_VALUE)*
  public static boolean PermissionLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PermissionLine")) return false;
    if (!nextTokenIs(b, PERMISSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PERMISSION_LINE, null);
    r = consumeTokens(b, 2, PERMISSION, SEPARATOR, PERMISSION_VALUE);
    p = r; // pin = 2
    r = r && PermissionLine_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (DOT PERMISSION_VALUE)*
  private static boolean PermissionLine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PermissionLine_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PermissionLine_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PermissionLine_3", c)) break;
    }
    return true;
  }

  // DOT PERMISSION_VALUE
  private static boolean PermissionLine_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PermissionLine_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, PERMISSION_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // postarg
  public static boolean PostArgLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PostArgLine")) return false;
    if (!nextTokenIs(b, POSTARG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POSTARG);
    exit_section_(b, m, POST_ARG_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // user separator ('player' | 'console' | 'everyone')
  public static boolean UserLine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UserLine")) return false;
    if (!nextTokenIs(b, USER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USER_LINE, null);
    r = consumeTokens(b, 2, USER, SEPARATOR);
    p = r; // pin = 2
    r = r && UserLine_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'player' | 'console' | 'everyone'
  private static boolean UserLine_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UserLine_2")) return false;
    boolean r;
    r = consumeToken(b, "player");
    if (!r) r = consumeToken(b, "console");
    if (!r) r = consumeToken(b, "everyone");
    return r;
  }

  /* ********************************************************** */
  // root_item*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (CommandDefinition)
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    if (!nextTokenIs(b, COMMANDNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CommandDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
